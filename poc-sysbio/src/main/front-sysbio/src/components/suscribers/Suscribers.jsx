import { Link } from 'solid-app-router'
import {Table } from "solid-bootstrap"
import { For } from 'solid-js';
import { createStore } from "solid-js/store"

function Suscribers() {
    const [state, setState] = createStore({
        suscribers: [{
            serialNumber: "001256354",
            company: "Sysbio",
            firstName: "Simon",
            lastName: "NGOS"
        }],
      });
    return (<>
    <nav>
      <Link href="/suscribers/new">New Suscriber</Link>
    </nav>
    <h2>Liste des suscribers</h2>
    <Table striped bordered hover>
        <thead>
            <tr>
            <th>N°</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            </tr>
        </thead>
        <tbody>
            <For each={state.suscribers} fallback={<div>loading...</div>}>
                {(item) =><>
                    <tr>
                        <td><Link href='/suscribers/15'>{item.serialNumber}</Link></td>
                        <td>{item.company}</td>
                        <td>{item.firstName}</td>
                        <td>{item.lastName}</td>
                    </tr>
                </>}
            </For>        
        </tbody>
    </Table>    
    </>
    )
}

export default Suscribers