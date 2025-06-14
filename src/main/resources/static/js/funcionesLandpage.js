 // Botón que redirige a la página para crear una venta
  document.getElementById('btnCrearCliente').addEventListener('click', () => {
    window.location.href = 'crear-cliente.html'; // Cambia esta URL a la ruta real de tu página
  });

  document.getElementById('btnCrearVenta').addEventListener('click', () => {
    window.location.href = 'crear-venta.html'; // Cambia esta URL a la ruta real de tu página
  });


function cargarFunciones() {
    fetch("http://localhost:8080/api/funciones")
        .then(res => {
            if (!res.ok) {
                throw new Error(`HTTP error! status: ${res.status}`);
            }
            return res.json();
        })
        .then(funciones => {
            const functionsTableBody = document.getElementById("functionsTableBody");
            functionsTableBody.innerHTML = ''; // Limpiar contenido anterior

            if (funciones.length === 0) {
                const row = functionsTableBody.insertRow();
                const cell = row.insertCell();
                cell.textContent = "No hay funciones registradas.";
                cell.colSpan = 1;
                cell.style.textAlign = 'center';
                cell.style.padding = '20px';
            } else {
                funciones.forEach(funcion => {
                    const row = functionsTableBody.insertRow();
                    const titulo = funcion.pelicula?.titulo || 'Sin título';
                    const horario = funcion.horario || 'Sin horario';
                    row.insertCell().textContent = `${titulo} (${horario})`;
                });
            }
        })
        .catch(err => console.error("Error al cargar funciones:", err));
}

window.addEventListener("DOMContentLoaded", () => {
        cargarFunciones();
        
    });