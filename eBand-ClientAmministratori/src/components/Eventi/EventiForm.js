import React, {Component} from 'react'

import axios from 'axios'

class EventiForm extends Component{

	constructor(props){
		super(props)
		this.state={
			tipologia:'',
			data:'',
			ora:'',
			cl:'',
			cp:'',
			cc:''
		}
	}

	changeHandler = (e) => {
		this.setState({[e.target.name]: e.target.value})
	}

	submitHandler = e => {
		e.preventDefault()
		console.log(this.state)
		axios
			.post('http://localhost:8080/eventi',this.state)
			.then(response => { 
				console.log(response)
			})
			.catch(error => {
				console.log(error)
			})
	}


	render(){

		const {tipologia,data,ora} = this.state

		return(
		<div>
		<br/>
		<h1>INSERIMENTO EVENTI</h1>
		<form onSubmit={this.submitHandler}>

			<div>
				Tipologia <br/> <input type="text" name="tipologia" value={tipologia} onChange={this.changeHandler} required/>
			</div>

			<div>
				Data <br/><input type="text" name="data" value={data} onChange={this.changeHandler} required/>
			</div>

			<div>
				Ora <br/><input type="text" name="ora" value={ora} onChange={this.changeHandler} required/>
			</div>

			<br/>
			<button type="submit" class="btn btn-success"> Inserisci  </button>
		</form>
		</div>
		)
	}
}

export default EventiForm