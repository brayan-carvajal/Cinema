document.addEventListener("DOMContentLoaded", function () {
  const track = document.getElementById("sliderTrack");
  let slides = document.querySelectorAll(".slide");

  function moveSlider() {
      // Aplicar transición suave
      track.style.transition = "transform 0.8s ease-in-out";

      // Mueve el slider a la izquierda
      track.style.transform = "translateX(-20%)";

      // Espera a que termine la animación para reorganizar los elementos
      setTimeout(() => {
          track.style.transition = "none"; // Desactiva transición para evitar parpadeo
          let firstSlide = slides[0];
          track.appendChild(firstSlide);
          track.style.transform = "translateX(0)"; // Devuelve el track a la posición original

          // Actualiza las diapositivas y resalta la del centro
          slides = document.querySelectorAll(".slide");
          slides.forEach((slide, index) => {
              slide.classList.toggle("active", index === 2);
          });

      }, 800); // Debe coincidir con la duración de la transición
  }

  setInterval(moveSlider, 3000); // Cambia cada 3 segundos
});

