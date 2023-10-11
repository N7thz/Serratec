/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/index.html"],
  theme: {
    extend: {
      colors: {
        'white-logo': '#F2F2F2',
        'green-logo': '#9BBF65',
        'green-light-logo': '#ABBF7E',
        'orange-logo': '#BF4A30'
      },

      fontFamily: {
        'sans': ['verdana', 'sans-serif'],
      },

      backgroundImage: {
        'image-background': "url(https://cdn.abjnoticias.com.br/abjnoticias-home/2022/08/frutas_verduras.jpeg)"
      },

      boxShadow: {
        'orange': '10px 10px #BF4A30',
        'orange-btn': '5px 5px #BF4A30'
      }
    },
  },
  plugins: [],
}

