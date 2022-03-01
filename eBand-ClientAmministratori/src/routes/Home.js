import * as React from "react";
import { Routes, Route, Link } from "react-router-dom";
import NavBar from '../Navbar'
import About from "../routes/Eventi.js";

import "./bootstrap.css";

function Home() {
  return (
    <>
      <main>
      <NavBar/>
        <h2>Benvenuti nella homepage di eBand!</h2>
        <p> Ti trovi nella sezione riservata all'amministratore, dedicata <br/>
        alla dirigenza dell'associazione musicale. <br/>
        Scopri le funzioni disponibili per gestire al meglio la banda muovendoti <br/>
        nell'applicazione usando la barra di navigazione!
        
        </p>
      </main>
     
    </>
  );
}

export default Home