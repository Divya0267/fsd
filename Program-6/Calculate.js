// src/AdvancedCalculator.js
import React, { useState } from 'react';
import './styles.css';

function AdvancedCalculator() {
  const [input, setInput] = useState('');
  const [result, setResult] = useState('');

  const handleClick = (value) => {
    setInput(input + value);
  };

  const calculate = () => {
    try {
      setResult(eval(input)); // caution: eval can be risky with unknown inputs
    } catch {
      setResult("Error");
    }
  };

  return (
    <div className="container">
      <div className="calc-text">
        <p>{result || input}</p>
      </div>
      <div className="calc-keys">
        {[1, 2, 3].map(num => <button key={num} onClick={() => handleClick(num)}>{num}</button>)}
        <button className="key-operate" onClick={() => handleClick('+')}>+</button>
        {[4, 5, 6].map(num => <button key={num} onClick={() => handleClick(num)}>{num}</button>)}
        <button className="key-operate" onClick={() => handleClick('-')}>-</button>
        {[7, 8, 9].map(num => <button key={num} onClick={() => handleClick(num)}>{num}</button>)}
        <button className="key-operate" onClick={() => handleClick('*')}>*</button>
        <button onClick={() => handleClick('0')}>0</button>
        <button className="key-others" onClick={() => handleClick('/')}>/</button>
        <button className="key-others" onClick={() => {setInput(''); setResult('');}}>Clear</button>
        <button className="key-operate" onClick={calculate}>=</button>
      </div>
    </div>
  );
}

export default AdvancedCalculator;
