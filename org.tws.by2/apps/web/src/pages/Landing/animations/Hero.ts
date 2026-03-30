import { gsap } from "gsap";

export function animateHero(container: any) {
  const ctx = gsap.context(() => {

    const tl = gsap.timeline();

    tl.from(".hero-image", { x: 300, opacity: 0 })
      .from(".hero-card", { y: 20, opacity: 0 })
      .from(".hero-title", { y: 40, opacity: 0 })
      .from(".hero-subtitle", { y: 40, opacity: 0 })
      .from(".hero-cadastro", { y: 40, opacity: 0 });

    // 🔁 Loop da imagem
    gsap.to(".hero-image", {
      y: 20,
      duration: 1.5,
      repeat: -1,
      yoyo: true,
      ease: "power1.inOut",
    });

  }, container);

  return () => ctx.revert();
}