import React, {Component} from 'react'

import axios from 'axios'

class PostFrom extends Component{

	constructor(props){
		super(props)
		this.state={
			nome:'',
			cognome:'',
			dob:'', 
			residenza:'', 
			dataisc:'', 
			ruolo1:'', 
			ruolo2:''
		}
	}

	changeHandler = (e) => {
		this.setState({[e.target.name]: e.target.value})
	}

	submitHandler = e => {
		e.preventDefault()
		console.log(this.state)
		axios
			.post('http://localhost:8080/soci',this.state)
			.then(response => { 
				console.log(response)
			})
			.catch(error => {
				console.log(error)
			})
	}


	render(){

		const {nome,cognome, dob, residenza, dataisc, ruolo1, ruolo2} = this.state

		return(
		<div>
		<br/>
		<h1>INSERIMENTO SOCIO</h1>
		<form onSubmit={this.submitHandler}>

			<div>
				Nome <br/> <input type="text" name="nome" value={nome} onChange={this.changeHandler} required />
			</div>

			<div>
				Cognome <br/><input type="text" name="cognome" value={cognome} onChange={this.changeHandler}required />
			</div>
			<div>
				Data di nascita <br/> <input type="text" name="dob" value={dob} onChange={this.changeHandler}required />
			</div>
			<div>
				Residenza <br/><input type="text" name="residenza" value={residenza} onChange={this.changeHandler} required/>
			</div>
			<div>
				Data iscrizione <br/> <input type="text" name="dataisc" value={dataisc} onChange={this.changeHandler}required/>
			</div>
			<div>
				Ruolo principale <br/><input type="text" name="ruolo1" value={ruolo1} onChange={this.changeHandler}required/>
			</div>
			<div>
				Ruolo secondario <br/> <input type="text" name="ruolo2" value={ruolo2} onChange={this.changeHandler}/>
			</div>
			<br/>
			<button type="submit" class="btn btn-success">Inserisci </button>
		</form>
		</div>
		)
	}
}

export default PostFrom