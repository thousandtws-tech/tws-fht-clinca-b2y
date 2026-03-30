import { gsap } from "gsap";

export function animateHeader(container: any) {
    const ctx = gsap.context(() => {
    const tl = gsap.timeline();

    tl.from(".header-logo", { x: -300, opacity: 0, duration: 1 })
      .from(".header-items", {
        x: 300,
        opacity: 0,
        duration: 1,
        stagger: 0.2,
      }, "-=0.5")

    }, container);

  return () => ctx.revert();
}