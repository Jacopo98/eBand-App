import React from 'react';
import userservice from '../../services/EventServices';
import {Navbar, Nav,Form,FormControl,Button}  from 'react-bootstrap';

class EventiComponents extends React.Component{

    constructor(props){
        super(props)
        this.state ={
            eventi:[]
        }
        
    }
    componentDidMount(){
        userservice.getEvent().then((Response) =>{
            this.setState({eventi:Response.data})
        });
    }

    render(){
        return(
            <div >
                <h1 className = "text-center" > LISTA EVENTI </h1>
                <table class="">
                    <thead class="table-light" >
                        <tr>
                            <th>ID Evento</th>
                            <th>Tipologia</th>
                            <th>Data</th>
                            <th>Ora</th>

                        </tr>
                    </thead>

                    <tbody>
                        {
                            this.state.eventi.map(
                                eventi =>
                                <tr key = {eventi.id}>
                                    <td>{eventi.id}</td>
                                    <td>{eventi.tipologia}</td>
                                    <td>{eventi.data}</td>
                                    <td>{eventi.ora}</td>
                                </tr>
                            )
                            }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default EventiComponents