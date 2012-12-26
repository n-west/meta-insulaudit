# Image for insulaudit, based on Angstrom's systemd-image. 
# Include some extra networking tools and usb drivers and utilities.

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

PR = "r0"

# Add to known working systemd-image from meta-angstrom
require recipes-images/angstrom/systemd-image.bb

# We want some extras

IMAGE_INSTALL += "socat usb-modeswitch kernel-module-hso \
		kernel-module-usbserial kernel-modules"

export IMAGE_BASENAME = "insulaudit-image"