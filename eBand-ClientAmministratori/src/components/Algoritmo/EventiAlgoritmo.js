import React from 'react';
import axios from 'axios';

export default class PersonList extends React.Component {
  constructor(props){
		super(props)
		this.state={
            persons: [],
			id:''
		}
	}

  changeHandler = (e) => {
		this.setState({[e.target.name]: e.target.value})
	}

  submitHandler = e => {
		e.preventDefault()
		console.log(this.state)
		axios.get('http://localhost:8080/esegui?id='+this.state.id)
      .then(res => {
        const persons = res.data;
        this.setState({ persons });
      })
	}

  render() {
      const {id} = this.state
    return (
            <div >

		    <form onSubmit={this.submitHandler}>

			    <div>
				    ID evento: <br/> <input type="text" name="id" value={id} onChange={this.changeHandler} required/>
			    </div>
			    <br/>
			    <button type="submit" class="btn btn-warning" > Calcola formazione e visualizza elenco </button>
		    </form>
            <br/>
            <br/>
                <h1 className = "text-center"> ELENCO SOCI </h1>
                <p>con relativo ruolo assegnato per l'evento selezionato.</p>
                <table class="">
                    <thead class="table-light">
                        <tr>
                            <th>User ID</th>
                            <th>Cognome</th>
                            <th>Nome</th>
                            <th>Ruolo</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            this.state.persons.map(
                                soci =>
                                <tr key = {soci.id}>
                                    <td>{soci.id}</td>
                                    <td>{soci.cognome}</td>
                                    <td>{soci.nome}</td>
                                    <td>{soci.ruolo}</td>
                                </tr>
                            )
                            }
                    </tbody>
                </table>
            </div>
    )
  }
}