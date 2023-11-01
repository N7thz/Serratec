import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

import Home from './pages/home.jsx'
import Contato from './pages/contato.jsx'
import Comentario from './pages/comentarios.jsx'
import Pessoa from './pages/pessoa.jsx'
import Erro404 from './pages/erro404.jsx';



const router = createBrowserRouter([
  {
    path: '/',
    element: <Home />,
    errorElement: <Erro404/>,
    children: [
      {
        path: 'noticias',
        element: <div>Aqui estaram as noticias</div>
      }
    ]
  },
  {
    path: '/contatos',
    element: <Contato />
  },
  {
    path: '/comentarios',
    element: <Contato />
  },
  {
    path: '/pessoa/:nome',
    element: <Pessoa />
  }

]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
