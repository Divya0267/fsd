import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import VotingSystem from './VotingSystem';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <VotingSystem></VotingSystem>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
// a react program implementing voting system..where there are two movie images side by side each image contains one like and one dislike button..each time like button is clicked the button should be incremented and for dislike button the count should be decremened and there should be a submit button on clicking this button we should get the winner..that is a text should be displayed that image1 has won by so and so votes, the two images are dangal.jpg and jersey.jpg