// import './App.css';
// import api from './api/axiosConfig';
// import {useState, useEffect} from 'react';
// import {Routes, Route} from 'react-router-dom';


// function App() {
//   const [quote, setQuote] = useState("");
//   const [quotes, setQuotes] = useState([]);

//   const getQuote = async () =>{
    
//     try
//     {

//       const response = await api.get("/");
//         // console.log(response.data);
//       setQuote(response.data);

//     } 
//     catch(err)
//     {
//       console.log(err);
//     }
//   }

//   useEffect(() => {
//     getQuote();
//   },[])

//   return (
//     <div className="App">
      

//     </div>
//   );
// }

// export default App;




import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect} from 'react';
import {Routes, Route} from 'react-router-dom';
import Home from './components/home/Home.js';
import AuthorQuotes from './components/authorQuotes/AuthorQuotes.js';

function App() {
  const [quote, setQuote] = useState("");
  const [quotes, setQuotes] = useState([]);

  const getQuote = async () => {
    try {
      const response = await api.get("/");
      setQuote(response.data);
    } catch(err) {
      console.log(err);
    }
  }

  const getQuotesByAuthor = async (author) => {
    try {
      const response = await api.get(`/author/${author}`);
      setQuotes(response.data);
    } catch(err) {
      console.log(err);
    }
  }

  useEffect(() => {
    getQuote();
  }, [])

  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home quote={quote} />} />
        <Route path="/author/:authorName" element={<AuthorQuotes getQuotesByAuthor={getQuotesByAuthor} quotes={quotes} />} />
      </Routes>
    </div>
  );
}

export default App;