import { defineConfig } from 'vite';
import solidPlugin from 'vite-plugin-solid';

export default defineConfig({
  plugins: [solidPlugin()],
  ssr: {
    noExternal: ["solid-bootstrap"]
  },
  build: {
    target: 'esnext',
    polyfillDynamicImport: false,
  },
});
