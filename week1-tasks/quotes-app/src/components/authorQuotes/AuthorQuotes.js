import { useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import '../../styles/authorQuotes.css';

function AuthorQuotes({ getQuotesByAuthor, quotes }) {
  const { authorName } = useParams();

  useEffect(() => {
    getQuotesByAuthor(authorName);
  }, [authorName, getQuotesByAuthor]);

//   return (
//     <div className="container mx-auto p-4">
//       <Link to="/" className="text-blue-500 mb-4 inline-block">← Back to Home</Link>
//       <h1 className="text-2xl mb-6">Quotes by {authorName}</h1>
//       <div className="grid gap-4">
//         {quotes.map((quote, index) => (
//           <div key={index} className="p-4 bg-gray-100 rounded">
//             <blockquote className="text-lg">"{quote.text}"</blockquote>
//           </div>
//         ))}
//       </div>
//     </div>
//   );

return (
    <div className="author-quotes-container">
      <Link to="/" className="back-link">Back to Home</Link>
      <h1 className="author-title">Quotes by "{authorName}"</h1>
      
      <div className="quotes-grid">
        {quotes.length > 0 ? (
          quotes.map((quote, index) => (
            <div key={index} className="quote-card">
              <p className="quote-text">{quote.text}</p>
              <p className="quote-author">— {quote.author}</p>
            </div>
          ))
        ) : (
          <div className="no-quotes">
            No quotes found for this author.
          </div>
        )}
      </div>
    </div>
  );
}

export default AuthorQuotes;