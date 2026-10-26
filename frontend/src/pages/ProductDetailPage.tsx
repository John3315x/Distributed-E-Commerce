import { ProductInfo } from "@/components/products/ProductInfo"
import { Button } from "@/components/ui/button"

export default function ProductDetailPage() {
    return (
        <div className="mx-auto w-full max-w-32xl px-6 py-8">

            {/* Volver */}
            <Button
                variant="ghost"
                className="mb-8"
            >
                ← Volver a productos
            </Button>

            {/* Producto */}
            <div className="grid gap-10 md:grid-cols-2">

                {/* Imagen */}
                <div className="overflow-hidden rounded-xl bg-muted">
                    <img
                        src="https://images.unsplash.com/photo-1496181133206-80ce9b88a853"
                        alt="Laptop Pro"
                        className="aspect-square h-full w-full object-cover"
                    />
                </div>

                {/* Información */}
                <ProductInfo
                    name="Laptop Pro"
                    category="Tecnología"
                    price={899.99}
                    description="Laptop de alto rendimiento diseñada para trabajo, estudio y entretenimiento. Cuenta con un diseño moderno y componentes pensados para ofrecer una experiencia fluida."
                />

            </div>
        </div>
    )
}