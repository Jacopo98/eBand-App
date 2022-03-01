import * as React from "react";
import { Routes, Route, Link } from "react-router-dom";
import NavBar from '../Navbar'
import Home from "../routes/Home.js";

import EventiForm from '../components/Eventi/EventiForm';
import EventiComponents from '../components/Eventi/EventiComponents';
import EventiDelete from '../components/Eventi/EventiDelete';
import EventiUpdate from '../components/Eventi/EventiUpdate';

import "./Componenti.css";
import "./bootstrap.css";


function Eventi() {
  return (
    <>
      <main>
      <NavBar/>
        <br/>
        <h2> Gestione degli eventi</h2>
        <p>Area dedicata alla visualizzazione e inserimento nel database degli eventi</p>
        <EventiForm/><br/>
        <center><EventiComponents/></center>
        <form action="">
            <button type="submit" class="btn btn-outline-success" data-mdb-ripple-color="dark">
                Aggiorna Tabella
            </button>  
        </form>
        <br/>
        <EventiDelete/>
        <br/>
        <EventiUpdate/> <br/>
      </main>
     
    </>
  );
}

export default Eventi;