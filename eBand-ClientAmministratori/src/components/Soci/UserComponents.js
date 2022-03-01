import React from 'react';
import userservice from '../../services/UserServices';
import {Navbar, Nav,Form,FormControl,Button}  from 'react-bootstrap';

class UserComponents extends React.Component{

    constructor(props){
        super(props)
        this.state ={
            soci:[]
        }
        
    }
    componentDidMount(){
        userservice.getUsers().then((Response) =>{
            this.setState({soci:Response.data})
        });
    }
    render(){
        return(
            <div >
                
                <h1 className = "text-center"> LISTA SOCI </h1>
                <table class="">
                    <thead class="table-light">
                        <tr>
                            <th>User Id</th>
                            <th>Cognome</th>
                            <th>Nome</th>
                            <th>Data nascita</th>
                            <th>Residenza</th>
                            <th>Data iscrizione</th>
                            <th>Ruolo 1</th>
                            <th>Ruolo 2</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            this.state.soci.map(
                                soci =>
                                <tr key = {soci.id}>
                                    <td>{soci.id}</td>
                                    <td>{soci.cognome}</td>
                                    <td>{soci.nome}</td>
                                    <td>{soci.dob}</td>
                                    <td>{soci.residenza}</td>
                                    <td>{soci.dataisc}</td>
                                    <td>{soci.ruolo1}</td>
                                    <td>{soci.ruolo2}</td>
                                </tr>
                            )
                            }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default UserComponents