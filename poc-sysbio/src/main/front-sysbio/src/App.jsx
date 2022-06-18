import { Routes, Route, Link } from 'solid-app-router'
import { lazy } from "solid-js";
import {Container} from "solid-bootstrap"

import MenuBar from './components/common/menubar/MenuBar'
const Home = lazy(() => import('./components/home/Home'))
const Suscribers = lazy(() => import('./components/suscribers/Suscribers'))
const SuscriberNew = lazy(() => import('./components/suscribers/new/SuscriberNew'))
const SuscriberEdit = lazy(() => import('./components/suscribers/edit/SuscriberEdit'))

function App() {
  return (<>
    <Container>
      <MenuBar />
    <nav>
      <Link href="/about">About</Link>
      <Link href="/">Home</Link>
      <Link href="/suscribers">Suscribers</Link>
      <Link href="/suscribers/new">New Suscriber</Link>
    </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<div>This site was made with Solid</div>} />
        <Route path="/suscribers" element={<Suscribers />} />
        <Route path="/suscribers/new" element={<SuscriberNew />} />
        <Route path="/suscribers/:id" element={<SuscriberEdit />} />
      </Routes>
      </Container>
  </>
  );
}

export default App
