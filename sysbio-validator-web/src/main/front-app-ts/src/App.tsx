import { Component, createMemo, JSX, on, Show } from 'solid-js';

import logo from './logo.svg';
import styles from './App.module.css';
import { Navigate, NavLink, Outlet, Route, Routes, useLocation } from 'solid-app-router';
import { authState, logout } from './auth';
import HomePage from './pages/home/Home';
import SomewherePage from './pages/SomewherePage';
import LoginPage from './pages/Login';
import NotFoundPage from './pages/NotFoundPage';

interface ProtectedProps {
  redirect: string;
}

function Protected(props: ProtectedProps) {
  const location = useLocation();

  const loginPath = createMemo(
    on(
      () => authState.isLoggedIn,
      (_, wasLoggedIn) => {
        if (!wasLoggedIn && location.pathname !== "/") {
          return `${props.redirect}?returnTo=${encodeURI(location.pathname)}`;
        }
        return props.redirect;
      }
    )
  );

  return (
    <Show
      when={authState.isLoggedIn}
      fallback={<Navigate href={loginPath()} />}>
      <Outlet />
    </Show>
  );
}

interface ProtectedRouteProps {
  path?: string;
  redirect: string;
  children: JSX.Element;
}

function ProtectedRoute(props: ProtectedRouteProps) {
  return (
    <Route path={props.path || "/"} element={<Protected redirect={props.redirect} />}>
      {props.children}
    </Route>
  );
}

function Header() {
  return (
    <header>
      <Show when={authState.isLoggedIn}>
        <div>
          Logged in as <strong>{authState.user!.name}</strong>
          {" | "}
          <button onClick={logout}>Logout</button>
        </div>
        <hr />
      </Show>
      <nav>
        <NavLink href="/">Home</NavLink>
        {" | "}
        <NavLink href="/somewhere">Somewhere</NavLink>
        {" | "}
        <NavLink href="/nowhere">Nowhere</NavLink>
      </nav>
    </header>
  );
}

const App: Component = () => {
  return (
    <>
      <Header />
      <hr />
      <Routes>
        <ProtectedRoute redirect='/login'>
          <Route path="/" component={HomePage} />
          <Route path="/somewhere" component={SomewherePage} />
        </ProtectedRoute>
        <Route path="/login" component={LoginPage} />
        <Route path="*all" component={NotFoundPage} />
      </Routes>
    </>
  );
};

export default App;
