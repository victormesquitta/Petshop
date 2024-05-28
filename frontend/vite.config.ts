import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  build: {
    assetsDir: 'assets', // Configure the base directory for static assets
  },
  server: {
    hmr: {
      overlay: true, // Ativa o overlay de erro
    },
  },
})

