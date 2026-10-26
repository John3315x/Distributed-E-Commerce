import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader } from "@/components/ui/card"
import {useNavigate} from "react-router-dom";
import {useState} from "react";


function LoginPage() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    const [error, setError] = useState("");

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

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
            navigate("/"); // Redirige a la página principal después del inicio de sesión exitoso

        } catch (error) {
            console.error("Error:", error);
            setError("Error de conexión con el servidor.");
        }
    }


    return (
        <div className="flex min-h-[calc(100vh-4rem)] items-center justify-center px-6 py-12">
            <Card className="w-full max-w-md">

                <CardHeader className="space-y-2 text-center">
                    <h1 className="text-2xl font-bold">
                        Iniciar sesión
                    </h1>

                    <p className="text-sm text-muted-foreground">
                        Ingresa a tu cuenta para continuar.
                    </p>
                </CardHeader>

                <CardContent>
                    <form className="space-y-6" onSubmit={handleSubmit}>

                        {/* Email */}
                        <div className="space-y-2">
                            <label htmlFor="email" className="text-sm font-medium"> Correo electrónico </label>
                            <Input
                                id="email"
                                type="email"
                                value={email}
                                onChange={(event) => setEmail(event.target.value)}
                                placeholder="correo@ejemplo.com"
                                required
                            />
                        </div>

                        {/* Contraseña */}
                        <div className="space-y-2">
                            <label htmlFor="password" className="text-sm font-medium"> Contraseña </label>

                            <Input
                                id="password"
                                type="password"
                                value={password}
                                onChange={(event) => setPassword(event.target.value)}
                                placeholder="Contraseña"
                                required
                            />
                        </div>

                        {/* Botón */}
                        <Button type="submit" className="w-full"> Iniciar sesión </Button>

                        {/* Registro */}
                        <p className="text-center text-sm text-muted-foreground">
                            ¿No tienes una cuenta?{" "}
                            <span className="font-medium text-foreground underline">
                                Crear cuenta
                            </span>
                        </p>
                    </form>
                </CardContent>
            </Card>

            {error && (
                <p className="error-message">
                    {error}
                </p>
            )}

        </div>
    )
}

export default LoginPage;