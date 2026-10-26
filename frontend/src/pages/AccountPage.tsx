import {
    User,
    Mail,
    Phone,
    MapPin,
    Shield,
} from "lucide-react"

import {
    Card,
    CardContent,
    CardHeader,
    CardTitle,
} from "@/components/ui/card"

import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"

export default function AccountPage() {
    return (
        <div className="mx-auto w-full max-w-5xl space-y-8">

            {/* Encabezado */}
            <section className="space-y-2">
                <div className="flex items-center gap-3">
                    <div className="rounded-lg bg-primary/10 p-2">
                        <User className="h-6 w-6" />
                    </div>

                    <h1 className="text-3xl font-bold tracking-tight">
                        Mi cuenta
                    </h1>
                </div>

                <p className="text-muted-foreground">
                    Administra tu información personal y los datos de tu cuenta.
                </p>
            </section>

            {/* Información personal */}
            <Card>
                <CardHeader>
                    <CardTitle>
                        Información personal
                    </CardTitle>
                </CardHeader>

                <CardContent className="space-y-6">

                    <div className="grid gap-6 md:grid-cols-2">

                        {/* Nombre */}
                        <div className="space-y-2">
                            <p className="text-sm font-medium">
                                Nombre completo
                            </p>

                            <div className="relative">
                                <User className="absolute left-3 top-1/2 h-4 w-4 -translate-y-1/2 text-muted-foreground" />

                                <Input
                                    id="name"
                                    className="pl-9"
                                    placeholder="Juan Pérez"
                                />
                            </div>
                        </div>

                        {/* Correo */}
                        <div className="space-y-2">
                            <p className="text-sm font-medium">
                                Correo electrónico
                            </p>

                            <div className="relative">
                                <Mail className="absolute left-3 top-1/2 h-4 w-4 -translate-y-1/2 text-muted-foreground" />

                                <Input
                                    id="email"
                                    type="email"
                                    className="pl-9"
                                    placeholder="correo@ejemplo.com"
                                />
                            </div>
                        </div>

                        {/* Teléfono */}
                        <div className="space-y-2">
                            <p className="text-sm font-medium">
                                Teléfono
                            </p>

                            <div className="relative">
                                <Phone className="absolute left-3 top-1/2 h-4 w-4 -translate-y-1/2 text-muted-foreground" />

                                <Input
                                    id="phone"
                                    className="pl-9"
                                    placeholder="8888-8888"
                                />
                            </div>
                        </div>

                        {/* Dirección */}
                        <div className="space-y-2">
                            <p className="text-sm font-medium">
                                Dirección
                            </p>

                            <div className="relative">
                                <MapPin className="absolute left-3 top-1/2 h-4 w-4 -translate-y-1/2 text-muted-foreground" />

                                <Input
                                    id="address"
                                    className="pl-9"
                                    placeholder="Dirección de envío"
                                />
                            </div>
                        </div>

                    </div>

                    <Button>
                        Guardar cambios
                    </Button>

                </CardContent>
            </Card>

            {/* Seguridad */}
            <Card>
                <CardHeader>
                    <CardTitle className="flex items-center gap-2">
                        <Shield className="h-5 w-5" />
                        Seguridad
                    </CardTitle>
                </CardHeader>

                <CardContent className="space-y-4">

                    <div>
                        <p className="font-medium">
                            Contraseña
                        </p>

                        <p className="text-sm text-muted-foreground">
                            Cambia la contraseña de tu cuenta.
                        </p>
                    </div>

                    <Button variant="outline">
                        Cambiar contraseña
                    </Button>

                </CardContent>
            </Card>

        </div>
    )
}