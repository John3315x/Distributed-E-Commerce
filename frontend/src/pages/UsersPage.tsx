import { useState } from "react";

function UsersPage() {

    const [users, setUsers] = useState<any[]>([]);
    const [error, setError] = useState("");

    const handleGetUsers = async () => {

        const accessToken = localStorage.getItem("accessToken");
        console.log(accessToken);

        try {

            const response = await fetch("/api/users/getUsers", {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${accessToken}`,
                },
            });

            if (!response.ok) {
                setError("Error: " + response.status + " " + response.statusText);
                return;
            }

            const data = await response.json();
            setUsers(data);
            setError("");
            console.log("Usuarios:", data);

        } catch (error) {

            console.error(error);
            setError("Error de conexión con el servidor.");
        }
    };

    return (
        <div className="users-container">
            <h1>Usuarios</h1>

            <button onClick={handleGetUsers}>
                Obtener usuarios
            </button>

            {error && (
                <p className="error-message"> <br></br>
                    {error}
                </p>
            )}

            <div>
                {users.map((user, index) => (
                    <div key={index}>
                        <pre>
                            {JSON.stringify(user, null, 2)}
                        </pre>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default UsersPage;