/*Adicionando (sticky) no header para que fique transparente conforme scroll*/
window.addEventListener("scroll", function() {
    const header = document.querySelector("header");
    header.classList.toggle("sticky", window.scrollY > 0);
});


/*Faz com que o "nav-itens a" do header fique roxo conforme o usuário vai passando pelas seções (mostra ao usuário em qual seção ele está*/
window.addEventListener("scroll", () => {
    const sections = document.querySelectorAll("section");
    const scrollY = window.scrollY || document.documentElement.scrollTop || document.body.scrollTop;

    sections.forEach(current => {
        let sectionHeight = current.offsetHeight;
        let sectionTop = current.offsetTop - 50; 
        let id = current.getAttribute("id");


        if(scrollY > sectionTop && scrollY <= sectionTop + sectionHeight) {
            document.querySelector(".nav-itens a[href='#" + id + "']").classList.add("active");
        } else {
            document.querySelector(".nav-itens a[href='#" + id + "']").classList.remove("active");
        }
    });
});

/*ScrollReveal que faz com que os itens apareçam conforme o scroll do usuário*/
ScrollReveal({ 
    reset: true,
    distance: '60px',
    duration: 2500,
    delay: 100
});

ScrollReveal().reveal('.home .info h2, .section-title-01, .section-title-02', { delay: 100, origin: 'left' });
ScrollReveal().reveal('.home .info h3, .home .info p, .sobre-nos .descricao', { delay: 100, origin: 'right' });
ScrollReveal().reveal('.home .info .btn', { delay: 100, origin: 'bottom' });
ScrollReveal().reveal('.home-img, .sobre-nos .integrantes', { delay: 100, origin: 'bottom' });
ScrollReveal().reveal('.home-img, .temperatura .cartoes', { delay: 100, origin: 'right', interval: 200 });

