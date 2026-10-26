import { useNavigate } from "react-router-dom";
import { useState } from "react";

function LoginPage0() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    const [error, setError] = useState("");

    /**
     * Este método se ejecuta cuando el usuario envía el formulario de inicio de sesión. Previene el comportamiento por
     * defecto del formulario y realiza una solicitud POST al endpoint de inicio de sesión con los datos del usuario.
     * @param event
     */
    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault(); // Evita que la página se recargue al enviar el formulario

        try {
            // const response = await fetch("http://localhost:8080/api/auth/login", {
            const response = await fetch("/api/auth/login", {

                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    email,
                    password,
                }),
            });

            if (!response.ok) {
                setError("Error: " + response.status + " " + response.statusText);
                return;
            }

            const data = await response.json();
            console.log("Login exitoso:", data);
            localStorage.setItem("accessToken", data.accessToken);
            setError("");
            navigate("/users"); // Redirige a la página de usuarios después del inicio de sesión exitoso

        } catch (error) {
            console.error("Error:", error);
            setError("Error de conexión con el servidor.");
        }
    };

    return (
        <div className="login-container">
            <div className="login-card">

                <h1 className="text-4xl font-bold text-blue-500">
                    E-Commerce Dashboard
                </h1>

                <h1>Iniciar sesión</h1>

                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="email">Correo electrónico</label>

                        <input
                            id="email"
                            type="email"
                            value={email}
                            onChange={(event) => setEmail(event.target.value)}
                            placeholder="correo@ejemplo.com"
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="password">Contraseña</label>

                        <input
                            id="password"
                            type="password"
                            value={password}
                            onChange={(event) => setPassword(event.target.value)}
                            placeholder="Contraseña"
                            required
                        />
                    </div>

                    <button type="submit">
                        Iniciar sesión
                    </button>
                </form>

                <br></br>

                {error && (
                    <p className="error-message">
                        {error}
                    </p>
                )}
            </div>
        </div>
    );


}


export default LoginPage0;