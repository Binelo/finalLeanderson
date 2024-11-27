// (function(){
//     $("#tabcapacete").on("click",".js-delete", function(){
//         let botaoClicado  = $(this);
//         $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
//         $("#modalcapacete").modal("show");
//     });

//     $("#btnsim").on("click",function(){
//         let botaoSim = $(this);
//         let id = botaoSim.attr("data-id");
//         $.ajax({
//             url: "/capacete/delete/" + id,
//             method: "GET",
//             success: function(){
//                 window.location.href="/capacete";
//             }
//         });
//     });

// })();
document.addEventListener("DOMContentLoaded", function () {
  const modal = document.getElementById("modalcapacete");
  const btnNao = document.getElementById("btnnao");
  const btnSim = document.getElementById("btnsim");

  document
    .getElementById("tabcapacete")
    .addEventListener("click", function (e) {
      if (e.target.classList.contains("js-delete")) {
        const capaceteId = e.target.getAttribute("data-id");
        btnSim.setAttribute("data-id", capaceteId);
        modal.style.display = "block";
      }
    });

  btnNao.addEventListener("click", function () {
    modal.style.display = "none";
  });

  btnSim.addEventListener("click", function () {
    const id = btnSim.getAttribute("data-id");

    fetch(`/capacete/delete/${id}`, { method: "GET" })
      .then((response) => {
        if (response.ok) {
          window.location.reload();
        } else {
          alert("Erro ao excluir o capacete.");
        }
      })
      .catch((err) => console.error("Erro na requisição:", err));

    modal.style.display = "none";
  });

  window.addEventListener("click", function (e) {
    if (e.target === modal) {
      modal.style.display = "none";
    }
  });
});

document.addEventListener("DOMContentLoaded", function () {
  const btnVoltar = document.getElementById("btnVoltar");
  const currentPath = window.location.pathname;
  const navLink = document.querySelector(".nav-link");

  if (currentPath.includes("/capacete/search")) {
    btnVoltar.style.display = "inline-block";
  }
  if (currentPath.includes("/capacete")) {
    navLink.style.color = "#691aeb";
  }
});

function voltar() {
  window.location.href = `/capacete/`;
}

function searchByNome(event) {
  event.preventDefault();

  const formData = new FormData(event.target);
  const data = Object.fromEntries(formData.entries());
  const filled = data.nome.trim("") != "";
  if (!filled) {
    alert("Preencha o campo")
  } else {
    window.location.href = `/capacete/search/${data.nome}`;
  }
}

const crescente = document.getElementById("crescente");
const decrescente = document.getElementById("decrescente");

crescente.addEventListener("click", () => {
  window.location.href = `/capacete/ordenar/${1}`;
})

decrescente.addEventListener("click", () => {
  window.location.href = `/capacete/ordenar/${0}`;
})