import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from "@tailwindcss/vite";
import * as path from "node:path";

// https://vite.dev/config/

// Esta configuración de Vite permite que las solicitudes a "/api" se redirijan al backend en "http://localhost:8080".
// Esto es útil para evitar problemas de CORS durante el desarrollo, ya que el frontend y el backend pueden estar
// corriendo en diferentes puertos.
export default defineConfig({
  plugins: [
      react(),
      tailwindcss(),
  ],

  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"),
    },
  },

  server: {
    proxy: {
      "/api": {
        target: "http://localhost:8080", // Si el gateway esta en un contenedor docker y el frontend en otro, usa la IP o nombre del contenedor del gateway
        changeOrigin: true,
      },
    },
  },
})
