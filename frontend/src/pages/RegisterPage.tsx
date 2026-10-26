import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import {
    Card,
    CardContent,
    CardHeader,
} from "@/components/ui/card"

export default function RegisterPage() {
    return (
        <div className="flex min-h-[calc(100vh-4rem)] items-center justify-center px-6 py-12">
            <Card className="w-full max-w-md">

                <CardHeader className="space-y-2 text-center">
                    <h1 className="text-2xl font-bold">
                        Crear cuenta
                    </h1>

                    <p className="text-sm text-muted-foreground">
                        Regístrate para comenzar a comprar.
                    </p>
                </CardHeader>

                <CardContent>
                    <form className="space-y-5">

                        {/* Nombre */}
                        <div className="space-y-2">
                            <label
                                htmlFor="name"
                                className="text-sm font-medium"
                            >
                                Nombre
                            </label>

                            <Input
                                id="name"
                                type="text"
                                placeholder="Tu nombre"
                            />
                        </div>

                        {/* Email */}
                        <div className="space-y-2">
                            <label
                                htmlFor="email"
                                className="text-sm font-medium"
                            >
                                Correo electrónico
                            </label>

                            <Input
                                id="email"
                                type="email"
                                placeholder="correo@ejemplo.com"
                            />
                        </div>

                        {/* Contraseña */}
                        <div className="space-y-2">
                            <label
                                htmlFor="password"
                                className="text-sm font-medium"
                            >
                                Contraseña
                            </label>

                            <Input
                                id="password"
                                type="password"
                                placeholder="••••••••"
                            />
                        </div>

                        {/* Confirmar contraseña */}
                        <div className="space-y-2">
                            <label
                                htmlFor="confirmPassword"
                                className="text-sm font-medium"
                            >
                                Confirmar contraseña
                            </label>

                            <Input
                                id="confirmPassword"
                                type="password"
                                placeholder="••••••••"
                            />
                        </div>

                        {/* Botón */}
                        <Button
                            type="submit"
                            className="w-full"
                        >
                            Crear cuenta
                        </Button>

                        {/* Login */}
                        <p className="text-center text-sm text-muted-foreground">
                            ¿Ya tienes una cuenta?{" "}
                            <span className="font-medium text-foreground underline">
                Iniciar sesión
              </span>
                        </p>

                    </form>
                </CardContent>

            </Card>
        </div>
    )
}