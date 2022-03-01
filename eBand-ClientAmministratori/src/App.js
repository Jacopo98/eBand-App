
import UserComponents from './components/Soci/UserComponents';
import PostForm from './components/Soci/PostForm';
import DeleteForm from './components/Soci/DeleteForm';
import EventiForm from './components/Eventi/EventiForm';
import EventiComponents from './components/Eventi/EventiComponents';
import UpdateForm from './components/Soci/UpdateForm';


import * as React from "react";
import { Routes, Route, Link } from "react-router-dom";

import Home from "./routes/Home.js";
import Eventi from "./routes/Eventi.js";
import Soci from "./routes/Soci.js";
import Algoritmo from "./routes/Algoritmo.js"


import Navbar from './Navbar';

function App() {
  return (
    <div className="App">
      
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="eventi" element={<Eventi />} />
        <Route path="soci" element={<Soci />} />
        <Route path="algoritmo" element={<Algoritmo />} />
      </Routes>
      
    </div>
  );
} 

export default App;
