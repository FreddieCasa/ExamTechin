import { useState } from 'react'
import './App.css'
import AddCategory from './components/AddCategory'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <AddCategory/>
    </>
  )
}

export default App
