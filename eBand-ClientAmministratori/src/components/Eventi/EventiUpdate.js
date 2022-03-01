import React, {Component} from 'react'

import axios from 'axios'

class EventiUpdate extends Component{

	constructor(props){
		super(props)
		this.state={
			id:'',
			tipologia:'',
			data:'',
			ora:''
		}
	}

	changeHandler = (e) => {
		this.setState({[e.target.name]: e.target.value})
	}

	submitHandler = e => {
		e.preventDefault()
		console.log(this.state)
		axios
			.put('http://localhost:8080/eventi/'+this.state.id, this.state)
			.then(response => { 
				console.log(response)
			})
			.catch(error => {
				console.log(error)
			})
	}


	render(){

		const {id,tipologia,data, ora} = this.state

		return(
		<div>
		<br/>
		<h1>MODIFICA EVENTO</h1>
		<form onSubmit={this.submitHandler}>
			
			<div>
				ID: <br/> <input type="text" name="id" value={id} onChange={this.changeHandler} required/>
			</div>
			
			<div>
				Tipologia <br/> <input type="text" name="tipologia" value={tipologia} onChange={this.changeHandler} required/>
			</div>

			<div>
				Data <br/><input type="text" name="data" value={data} onChange={this.changeHandler} required/>
			</div>
			<div>
				Ora <br/><input type="text" name="ora" value={ora} onChange={this.changeHandler}  required/>
			</div>

			<br/>
			<button type="submit" class="btn btn-success">Aggiorna </button>

		</form>
		</div>
		)
	}
}

export default EventiUpdate