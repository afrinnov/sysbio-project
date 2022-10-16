import { Navigate, useSearchParams } from "solid-app-router";
import { JSX, Show } from "solid-js";
import { authState, login } from "../auth";

export default function LoginPage() {
    const [search] = useSearchParams();

    const handleLogin: JSX.EventHandler<HTMLFormElement, Event> = (evt) => {
        evt.preventDefault();
        const data = new FormData(evt.currentTarget);
        login({
            name: data.get("name")!.toString()
        });
    };

    return (
        <Show when={!authState.isLoggedIn}
            fallback={<Navigate href={decodeURI(search.returnTo || "/")} />}
        >
            <main>
                <form onSubmit={handleLogin}>
                    <label>
                        User Name
                        <input name="name" required />
                    </label>
                    <button>Login</button>
                </form>
            </main>
        </Show>
    )
}