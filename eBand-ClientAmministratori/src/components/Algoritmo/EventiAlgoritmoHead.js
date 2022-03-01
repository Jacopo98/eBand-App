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
		axios.get('http://localhost:8080/datiformazione?id='+this.state.id)
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
            <h1>FORMAZIONE:</h1>  
            <center>
            <table class="dati">

                    
                        {
                            this.state.persons.map(
                                soci =>
                                <tr key = {soci.id}>
                                    <tr><td class="centro"><h4>Flauti: {soci.n_flauti}</h4></td></tr>
                                    <tr><td class="centro"><h4>Clarinetti: {soci.n_clarinetti}</h4></td></tr>
                                    <tr><td class="centro"><h4>Trombe: {soci.n_trombe}</h4></td></tr>
                                    <tr><td class="centro"><h4>Sax: {soci.n_sax}</h4></td></tr>
                                    <tr><td class="centro"><h4>Tube: {soci.n_tube}</h4></td></tr>
                                    <tr><td class="centro"><h4>Percussioni: {soci.n_percussioni}</h4></td></tr>
                                    <tr><td class="centro"><h4>Totale presenti: <b>{soci.n_tot}</b></h4></td></tr>
                                </tr>
                            )
                            }   
            </table>
            </center>
            <br/>       
            </div>
    )
  }
}