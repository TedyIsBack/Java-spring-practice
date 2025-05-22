import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [game, setGame] = useState(null);
  const startNewGame = async ()=>{

  const response = await fetch(
    "http://localhost:8090/hangman-games/?playerId=1",{
    method: "POST"
  });

  const currentGame = await response.json();
  console.log(currentGame);
  setGame(currentGame);
  }
  return (
    <>
      <div>
        <h2> Hangman game </h2>

        <button onClick={startNewGame}>Reset game</button>
       </div>
    </>
  )
}

export default App
