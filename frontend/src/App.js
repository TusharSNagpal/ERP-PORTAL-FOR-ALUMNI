import logo from './images/IIITBLogo1.jpg';
import React from 'react';
import {useState} from "react";
import './App.css';
import Searching from './Components/form';

import Button from "react-bootstrap/Button";
function App() {

  return (
    <div className="App">
        {/*<h2>IIITB ERP PORTAL</h2>*/}
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        {/*<p>*/}
        {/*  Edit <code>src/App.js</code> and save to reload.*/}
        {/*</p>*/}
        <a
          // className="App-link"
          // href="https://reactjs.org"
          // target="_blank"
          // rel="noopener noreferrer"
        >
        </a>
          <Searching>
          </Searching>
      </header>
    </div>
  );
}

export default App;
