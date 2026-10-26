import { BrowserRouter, Routes, Route } from "react-router-dom"

import { SidebarProvider, SidebarTrigger,} from "@/components/ui/sidebar"

import { AppSidebar } from "@/components/dashboard/AppSidebar"

import DashboardPage from "@/pages/DashboardPage"
import ProductsPage from "@/pages/ProductsPage"
import OffersPage from "@/pages/OffersPage"
import ProductDetailPage from "@/pages/ProductDetailPage"
import CartPage from "@/pages/CartPage"
import LoginPage from "@/pages/LoginPage"
import RegisterPage from "@/pages/RegisterPage"
import CheckoutPage from "@/pages/CheckoutPage"
import OrdersPage from "@/pages/OrdersPage"
import AccountPage from "@/pages/AccountPage"

function App() {
    return (
        <BrowserRouter>

            <Routes>

                {/* ========================= */}
                {/* Rutas sin Sidebar */}
                {/* ========================= */}

                <Route
                    path="/login"
                    element={<LoginPage />}
                />

                <Route
                    path="/registro"
                    element={<RegisterPage />}
                />


                {/* ========================= */}
                {/* Rutas de la tienda */}
                {/* ========================= */}

                <Route
                    path="*"
                    element={
                        <SidebarProvider>

                            <AppSidebar />

                            <main className="flex-1">

                                <header className="flex h-14 items-center border-b px-4">
                                    <SidebarTrigger />
                                </header>

                                <div className="p-6">
                                    <Routes>

                                        <Route
                                            path="/"
                                            element={<DashboardPage />}
                                        />

                                        <Route
                                            path="/productos"
                                            element={<ProductsPage />}
                                        />

                                        <Route
                                            path="/ofertas"
                                            element={<OffersPage />}
                                        />

                                        <Route
                                            path="/productos/:id"
                                            element={<ProductDetailPage />}
                                        />

                                        <Route
                                            path="/carrito"
                                            element={<CartPage />}
                                        />

                                        <Route
                                            path="/checkout"
                                            element={<CheckoutPage />}
                                        />

                                        <Route
                                            path="/cuenta"
                                            element={<AccountPage />}
                                        />

                                        <Route
                                            path="/mis-pedidos"
                                            element={<OrdersPage />}
                                        />

                                    </Routes>
                                </div>

                            </main>

                        </SidebarProvider>
                    }
                />

            </Routes>

        </BrowserRouter>
    )
}

export default App