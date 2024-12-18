import React, { useState } from 'react';
import dangal from './dangal.jpg';
import jersey from './jersey.jpg';

function VotingSystem() {
  const [dangalVotes, setDangalVotes] = useState(0);
  const [jerseyVotes, setJerseyVotes] = useState(0);
  const [winner, setWinner] = useState("");

  const handleDangalLike = () => setDangalVotes(dangalVotes + 1);
  const handleDangalDislike = () => setDangalVotes(dangalVotes - 1);
  const handleJerseyLike = () => setJerseyVotes(jerseyVotes + 1);
  const handleJerseyDislike = () => setJerseyVotes(jerseyVotes - 1);

  const handleSubmit = () => {
    if (dangalVotes > jerseyVotes) {
      setWinner(`Dangal has won by ${dangalVotes - jerseyVotes} votes!`);
    } else if (jerseyVotes > dangalVotes) {
      setWinner(`Jersey has won by ${jerseyVotes - dangalVotes} votes!`);
    } else {
      setWinner("It's a tie!");
    }
  };

  const containerStyle = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    minHeight: '100vh',
    paddingTop: '30px',
  };

  const movieContainerStyle = {
    display: 'flex',
    justifyContent: 'space-around',
    width: '100%',
    maxWidth: '1000px',
    marginBottom: '20px',
    gap: '20px',
  };

  const movieCardStyle = {
    textAlign: 'center',
    padding: '20px',
    border: '1px solid black',
    borderRadius: '15px',
    width: '280px',
  };

  const buttonStyle = {
    margin: '10px',
    padding: '12px 16px',
    fontSize: '1rem',
    cursor: 'pointer',
    borderRadius: '8px',
    border: 'none',
    color: '#fff',
  };

  const likeButtonStyle = {
    ...buttonStyle,
    backgroundColor: '#28a745',
  };

  const dislikeButtonStyle = {
    ...buttonStyle,
    backgroundColor: '#dc3545',
  };

  const submitButtonStyle = {
    ...buttonStyle,
    backgroundColor: '#007bff',
    marginTop: '20px',
    padding: '12px 24px',
  };

  return (
    <div style={containerStyle}>
      <h1 style={{ fontSize: '2rem', marginBottom: '20px' }}>Vote for Your Favorite Movie</h1>
      <div style={movieContainerStyle}>
        
        <div style={movieCardStyle}>
          <h3>Dangal</h3>
          <img src={dangal} alt="Dangal" style={{ width: '100%', height: '300px', borderRadius: '10px' }} />
          <div>
            <button onClick={handleDangalLike} style={likeButtonStyle}>Like ({dangalVotes})</button>
            <button onClick={handleDangalDislike} style={dislikeButtonStyle}>Dislike</button>
          </div>
        </div>

        <div style={movieCardStyle}>
          <h3>Jersey</h3>
          <img src={jersey} alt="Jersey" style={{ width: '100%', height: '300px', borderRadius: '10px' }} />
          <div>
            <button onClick={handleJerseyLike} style={likeButtonStyle}>Like ({jerseyVotes})</button>
            <button onClick={handleJerseyDislike} style={dislikeButtonStyle}>Dislike</button>
          </div>
        </div>
      </div>

      <button onClick={handleSubmit} style={submitButtonStyle}>Submit</button>
      {winner && <h2 style={{ marginTop: '20px' }}>{winner}</h2>}
    </div>
  );
}

export default VotingSystem;
