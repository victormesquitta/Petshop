import React from 'react'
import ReactDOM from 'react-dom/client'
import { App } from './App.tsx'
import { AuthService } from './services/AuthService.ts'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <App authService={new AuthService()} />
  </React.StrictMode>,
)
