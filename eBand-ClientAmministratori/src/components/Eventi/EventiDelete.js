import React, {Component} from 'react'

import axios from 'axios'

class EventiDelete extends Component{

	constructor(props){
		super(props)
		this.state={
			id:''
		}
	}

	changeHandler = (e) => {
		this.setState({[e.target.name]: e.target.value})
	}

	submitHandler = e => {
		e.preventDefault()
		console.log(this.state)
		axios
			.delete('http://localhost:8080/eventi/'+this.state.id)
			.then(response => { 
				console.log(response)
			})
			.catch(error => {
				console.log(error)
			})
	}

	render(){

		const {id} = this.state

		return(
		<div>
		<br/>
		<h1>CANCELLAZIONE EVENTO</h1>
		<form onSubmit={this.submitHandler}>

			<div>
				ID evento: <br/> <input type="text" name="id" value={id} onChange={this.changeHandler} required/>
			</div>
			<br/>
			<button type="submit" class="btn btn-danger" >Rimuovi dal database </button>
		</form>
		</div>
		)
	}
}

export default EventiDelete