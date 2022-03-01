import React from 'react';
import './App.css';
import { Link } from 'react-router-dom'

function Navbar(){
	return (
		<div className="Navbar">
		<h1>eBand</h1>
		<ul className="Links">
			<li>
               <Link to="/" className="Link">Home</Link>
            </li>
            <li>
               <Link to="/eventi" className="Link">Eventi</Link>
            </li>
            <li>
               <Link to='/soci' className="Link">Soci</Link>
            </li>
			<li>
               <Link to='/algoritmo' className="Link">EventOptimizer</Link>
            </li>
		</ul>
		</div>
	);
}
 
export default Navbar;