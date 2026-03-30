import { gsap } from "gsap";
import { ScrollTrigger } from "gsap/ScrollTrigger";

gsap.registerPlugin(ScrollTrigger);

export function animateAbout(container: any) {
  const ctx = gsap.context(() => {

    gsap.timeline({
      scrollTrigger: {
        trigger: ".about-title",
        start: "top 80%",
        once: true,
      },
    })
      .from(".about-title", { opacity: 0, y: 50 })
      .from(".card1, .card2, .card3, .card4", {
        y: 20,
        opacity: 0,
        stagger: 0.2,
      });

  }, container);

  return () => ctx.revert();
}