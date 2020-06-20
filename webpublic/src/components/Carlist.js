import React, { Component } from 'react';
import {ReactTable} from 'react-table';
// import 'react-table/react-table.css';
import {SERVER_URL} from '../constants';

class Carlist extends Component {
    constructor(props){
        super(props);
        this.state = {cars: []};
    }

    componentDidMount(){
        fetch(SERVER_URL+'api/cars')
        .then(response => response.json())
        .then(data=>{
            this.setState({
                cars : data._embedded.cars,
            });

            console.log(data);
        })
        .catch(err => console.error(err));
    }
    render(){
        const columns = [{
            Header: 'Brand',
            accessor: 'brand'
        }, {
            Header: 'Model',
            accessor: 'model'
        }, {
            Header: 'Color',
            accessor: 'color'
        }, {
            Header: 'Year',
            accessor: 'year'
        }, {
            Header: 'Price',
            accessor: 'price'
        }
        ];
    
        return (
            <div>
                <ReactTable data={this.state.cars} columns={columns} filterable={true}/>
            </div>
        )
    }
}

export default Carlist;