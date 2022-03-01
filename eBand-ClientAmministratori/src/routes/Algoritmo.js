import * as React from "react";
import { Routes, Route, Link } from "react-router-dom";
import NavBar from '../Navbar'
import Home from "../routes/Home.js";


import EventiAlgoritmo from '../components/Algoritmo/EventiAlgoritmo'
import EventiAlgoritmoHead from '../components/Algoritmo/EventiAlgoritmoHead'

import "./Componenti.css";
import "./bootstrap.css";


function Algoritmo() {
  return (
    <>
      <main>
      <NavBar/>
        <br/>
        <h2> Ottimizzazione degli eventi</h2>
        <p>Area dedicata alla visualizzazione della formazione proposta dall'algoritmo per l'evento selezionato. </p>
        <center><EventiAlgoritmoHead/></center>
        <center><EventiAlgoritmo/></center>
        
        <br/>
       
      </main>
     
    </>
  );
}

export default Algoritmo;