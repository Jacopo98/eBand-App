import * as React from "react";
import { Routes, Route, Link } from "react-router-dom";
import NavBar from '../Navbar'
import Home from "../routes/Home.js";

import UserComponents from '../components/Soci/UserComponents';
import PostForm from '../components/Soci/PostForm';
import DeleteForm from '../components/Soci/DeleteForm';
import UpdateForm from '../components/Soci/UpdateForm';

import "./Componenti.css";
import "./bootstrap.css";

function Soci() {
  return (
    <>
      <main>
      <NavBar/>
        <br/>
        <h2> Gestione dei soci</h2>
        <p>Area dedicata alla visualizzazione, inserimento, modifica e cancellazione dei soci database degli eventi</p>
        <PostForm/><br/>
        <center><UserComponents/></center>

        <form action="">
            <button type="submit" class="btn btn-outline-success" data-mdb-ripple-color="dark">
                Aggiorna Tabella
            </button>  
        </form>
        <br/>
        <DeleteForm/><br/>
        <UpdateForm/>
        <br/>
      </main>
     
    </>
  );
}

export default Soci;