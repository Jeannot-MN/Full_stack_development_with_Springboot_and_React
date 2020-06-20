import React, {Component} from 'react';
import CarList from './components/Carlist'
import './App.css';

class App extends Component{
  render(){
    return(
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">CarList</h1>
        </header>
        <CarList/>
      </div>
    )
  }
}

export default App;