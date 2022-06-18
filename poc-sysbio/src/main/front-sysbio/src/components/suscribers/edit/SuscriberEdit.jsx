import { useParams } from 'solid-app-router'

function SuscriberEdit() {
    const params = useParams();

    return (`<h2>Edit Suscriber ${params.id}</h2>`)
}

export default SuscriberEdit