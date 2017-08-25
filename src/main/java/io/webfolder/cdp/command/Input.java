/**
 * cdp4j - cdp4j - Chrome DevTools Protocol for Java
 * Copyright © 2017 WebFolder OÜ (support@webfolder.io)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.webfolder.cdp.command;

import io.webfolder.cdp.annotation.Domain;
import io.webfolder.cdp.annotation.Experimental;
import io.webfolder.cdp.annotation.Optional;
import io.webfolder.cdp.type.constant.KeyEventType;
import io.webfolder.cdp.type.constant.MouseButtonType;
import io.webfolder.cdp.type.constant.MouseEventType;
import io.webfolder.cdp.type.constant.TouchEventType;
import io.webfolder.cdp.type.input.GestureSourceType;
import io.webfolder.cdp.type.input.TouchPoint;
import java.util.List;

@Domain("Input")
public interface Input {
    /**
     * Ignores input events (useful while auditing page).
     * 
     * @param ignore Ignores input events processing when set to true.
     */
    void setIgnoreInputEvents(Boolean ignore);

    /**
     * Dispatches a key event to the page.
     * 
     * @param type Type of the key event.
     * @param modifiers Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     * @param timestamp Time at which the event occurred.
     * @param text Text as generated by processing a virtual key code with a keyboard layout. Not needed for for <code>keyUp</code> and <code>rawKeyDown</code> events (default: "")
     * @param unmodifiedText Text that would have been generated by the keyboard if no modifiers were pressed (except for shift). Useful for shortcut (accelerator) key handling (default: "").
     * @param keyIdentifier Unique key identifier (e.g., 'U+0041') (default: "").
     * @param code Unique DOM defined string value for each physical key (e.g., 'KeyA') (default: "").
     * @param key Unique DOM defined string value describing the meaning of the key in the context of active modifiers, keyboard layout, etc (e.g., 'AltGr') (default: "").
     * @param windowsVirtualKeyCode Windows virtual key code (default: 0).
     * @param nativeVirtualKeyCode Native virtual key code (default: 0).
     * @param autoRepeat Whether the event was generated from auto repeat (default: false).
     * @param isKeypad Whether the event was generated from the keypad (default: false).
     * @param isSystemKey Whether the event was a system key event (default: false).
     */
    void dispatchKeyEvent(KeyEventType type, @Optional Integer modifiers,
            @Optional Double timestamp, @Optional String text, @Optional String unmodifiedText,
            @Optional String keyIdentifier, @Optional String code, @Optional String key,
            @Optional Integer windowsVirtualKeyCode, @Optional Integer nativeVirtualKeyCode,
            @Optional Boolean autoRepeat, @Optional Boolean isKeypad,
            @Optional Boolean isSystemKey);

    /**
     * Dispatches a mouse event to the page.
     * 
     * @param type Type of the mouse event.
     * @param x X coordinate of the event relative to the main frame's viewport in CSS pixels.
     * @param y Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
     * @param modifiers Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     * @param timestamp Time at which the event occurred.
     * @param button Mouse button (default: "none").
     * @param clickCount Number of times the mouse button was clicked (default: 0).
     * @param deltaX X delta in CSS pixels for mouse wheel event (default: 0).
     * @param deltaY Y delta in CSS pixels for mouse wheel event (default: 0).
     */
    void dispatchMouseEvent(MouseEventType type, Double x, Double y, @Optional Integer modifiers,
            @Optional Double timestamp, @Optional MouseButtonType button,
            @Optional Integer clickCount, @Optional Double deltaX, @Optional Double deltaY);

    /**
     * Dispatches a touch event to the page.
     * 
     * @param type Type of the touch event.
     * @param touchPoints Touch points.
     * @param modifiers Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     * @param timestamp Time at which the event occurred.
     */
    @Experimental
    void dispatchTouchEvent(TouchEventType type, List<TouchPoint> touchPoints,
            @Optional Integer modifiers, @Optional Double timestamp);

    /**
     * Emulates touch event from the mouse event parameters.
     * 
     * @param type Type of the mouse event.
     * @param x X coordinate of the mouse pointer in DIP.
     * @param y Y coordinate of the mouse pointer in DIP.
     * @param timestamp Time at which the event occurred.
     * @param button Mouse button.
     * @param deltaX X delta in DIP for mouse wheel event (default: 0).
     * @param deltaY Y delta in DIP for mouse wheel event (default: 0).
     * @param modifiers Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     * @param clickCount Number of times the mouse button was clicked (default: 0).
     */
    @Experimental
    void emulateTouchFromMouseEvent(MouseEventType type, Integer x, Integer y, Double timestamp,
            MouseButtonType button, @Optional Double deltaX, @Optional Double deltaY,
            @Optional Integer modifiers, @Optional Integer clickCount);

    /**
     * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
     * 
     * @param x X coordinate of the start of the gesture in CSS pixels.
     * @param y Y coordinate of the start of the gesture in CSS pixels.
     * @param scaleFactor Relative scale factor after zooming (>1.0 zooms in, <1.0 zooms out).
     * @param relativeSpeed Relative pointer speed in pixels per second (default: 800).
     * @param gestureSourceType Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
     */
    @Experimental
    void synthesizePinchGesture(Double x, Double y, Double scaleFactor,
            @Optional Integer relativeSpeed, @Optional GestureSourceType gestureSourceType);

    /**
     * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
     * 
     * @param x X coordinate of the start of the gesture in CSS pixels.
     * @param y Y coordinate of the start of the gesture in CSS pixels.
     * @param xDistance The distance to scroll along the X axis (positive to scroll left).
     * @param yDistance The distance to scroll along the Y axis (positive to scroll up).
     * @param xOverscroll The number of additional pixels to scroll back along the X axis, in addition to the given distance.
     * @param yOverscroll The number of additional pixels to scroll back along the Y axis, in addition to the given distance.
     * @param preventFling Prevent fling (default: true).
     * @param speed Swipe speed in pixels per second (default: 800).
     * @param gestureSourceType Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
     * @param repeatCount The number of times to repeat the gesture (default: 0).
     * @param repeatDelayMs The number of milliseconds delay between each repeat. (default: 250).
     * @param interactionMarkerName The name of the interaction markers to generate, if not empty (default: "").
     */
    @Experimental
    void synthesizeScrollGesture(Double x, Double y, @Optional Double xDistance,
            @Optional Double yDistance, @Optional Double xOverscroll, @Optional Double yOverscroll,
            @Optional Boolean preventFling, @Optional Integer speed,
            @Optional GestureSourceType gestureSourceType, @Optional Integer repeatCount,
            @Optional Integer repeatDelayMs, @Optional String interactionMarkerName);

    /**
     * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
     * 
     * @param x X coordinate of the start of the gesture in CSS pixels.
     * @param y Y coordinate of the start of the gesture in CSS pixels.
     * @param duration Duration between touchdown and touchup events in ms (default: 50).
     * @param tapCount Number of times to perform the tap (e.g. 2 for double tap, default: 1).
     * @param gestureSourceType Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
     */
    @Experimental
    void synthesizeTapGesture(Double x, Double y, @Optional Integer duration,
            @Optional Integer tapCount, @Optional GestureSourceType gestureSourceType);

    /**
     * Dispatches a key event to the page.
     * 
     * @param type Type of the key event.
     */
    void dispatchKeyEvent(KeyEventType type);

    /**
     * Dispatches a mouse event to the page.
     * 
     * @param type Type of the mouse event.
     * @param x X coordinate of the event relative to the main frame's viewport in CSS pixels.
     * @param y Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
     */
    void dispatchMouseEvent(MouseEventType type, Double x, Double y);

    /**
     * Dispatches a touch event to the page.
     * 
     * @param type Type of the touch event.
     * @param touchPoints Touch points.
     */
    @Experimental
    void dispatchTouchEvent(TouchEventType type, List<TouchPoint> touchPoints);

    /**
     * Emulates touch event from the mouse event parameters.
     * 
     * @param type Type of the mouse event.
     * @param x X coordinate of the mouse pointer in DIP.
     * @param y Y coordinate of the mouse pointer in DIP.
     * @param timestamp Time at which the event occurred.
     * @param button Mouse button.
     */
    @Experimental
    void emulateTouchFromMouseEvent(MouseEventType type, Integer x, Integer y, Double timestamp,
            MouseButtonType button);

    /**
     * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
     * 
     * @param x X coordinate of the start of the gesture in CSS pixels.
     * @param y Y coordinate of the start of the gesture in CSS pixels.
     * @param scaleFactor Relative scale factor after zooming (>1.0 zooms in, <1.0 zooms out).
     */
    @Experimental
    void synthesizePinchGesture(Double x, Double y, Double scaleFactor);

    /**
     * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
     * 
     * @param x X coordinate of the start of the gesture in CSS pixels.
     * @param y Y coordinate of the start of the gesture in CSS pixels.
     */
    @Experimental
    void synthesizeScrollGesture(Double x, Double y);

    /**
     * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
     * 
     * @param x X coordinate of the start of the gesture in CSS pixels.
     * @param y Y coordinate of the start of the gesture in CSS pixels.
     */
    @Experimental
    void synthesizeTapGesture(Double x, Double y);
}
