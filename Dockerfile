FROM artifacts.microchip.com:7999/microchip/citd/nodejs:12.x as nodejs
FROM artifacts.microchip.com:7999/microchip/citd/ant:1.10.3 as ant
FROM artifacts.microchip.com:7999/microchip/citd/jdk8:1.8.0_202

COPY --from=nodejs / /
COPY --from=ant / /
