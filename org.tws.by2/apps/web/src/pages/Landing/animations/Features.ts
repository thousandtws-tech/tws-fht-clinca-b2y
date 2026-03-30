import { gsap } from "gsap";
import { ScrollTrigger } from "gsap/ScrollTrigger";

gsap.registerPlugin(ScrollTrigger);

export function animateFeatures(container: any) {
  const ctx = gsap.context(() => {

    gsap.timeline({
      scrollTrigger: {
        trigger: ".features-title",
        start: "top 80%",
        once: true,
      },
    })
      .from(".features-title", { opacity: 0, y: 50 })
      .from(".features-subtitle", { opacity: 0, y: 50 })
      .from(".features-card1, .features-card2", {
        y: 20,
        opacity: 0,
        stagger: 0.2,
      });

  }, container);

  return () => ctx.revert();
}