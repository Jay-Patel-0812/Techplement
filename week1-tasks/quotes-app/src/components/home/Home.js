import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
// import '../../styles/home.scss';
// import '../../styles/'
import '../../styles/home.css';

function Home({ quote }) {
  const [searchAuthor, setSearchAuthor] = useState('');
  const navigate = useNavigate();

  const handleSearch = (e) => {
    e.preventDefault();
    if (searchAuthor.trim()) {
      navigate(`/author/${searchAuthor}`);
    }
  }

  // return (
  //   <div className="container mx-auto p-4">
  //     <div className="quote-container mb-8 p-6 bg-gray-100 rounded-lg">
  //       <blockquote className="text-xl">"{quote.text}"</blockquote>
  //       <p className="text-right mt-4">- {quote.author}</p>
  //     </div>
      
  //     <form onSubmit={handleSearch} className="flex gap-2">
  //       <input
  //         type="text"
  //         placeholder="Search by author name..."
  //         value={searchAuthor}
  //         onChange={(e) => setSearchAuthor(e.target.value)}
  //         className="flex-1 p-2 border rounded"
  //       />
  //       <button type="submit" className="px-4 py-2 bg-blue-500 text-white rounded">
  //         Search
  //       </button>
  //     </form>
  //   </div>
  // );

  return (
    <div className="home-container">
      <div className="quote-container">
        <p className="quote-text">{quote.text}</p>
        <p className="quote-author">— {quote.author}</p>
      </div>
      
      <div className="search-container">
        <form onSubmit={handleSearch} className="search-form">
          <input
            type="text"
            placeholder="Search by author name..."
            value={searchAuthor}
            onChange={(e) => setSearchAuthor(e.target.value)}
          />
          <button type="submit">Search</button>
        </form>
      </div>
    </div>
  );
}

export default Home;